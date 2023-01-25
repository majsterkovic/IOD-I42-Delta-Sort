import 'dart:async';
import 'dart:convert';

import 'package:dio/dio.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';
import 'package:sort_client/sort_api/sort_api.dart';

import '../../../bloc/algorithm_bloc.dart';

class SimpleSortBloc extends FormBloc<List<SortResponse>, String> {
  SimpleSortBloc()
      : reverse = BooleanFieldBloc(name: 'Reverse'),
        type = SelectFieldBloc(
          name: 'Type',
          items: DataType.values,
          initialValue: DataType.string,
        ),
        iterations = TextFieldBloc(name: "Iterations"),
        algorithms = AlgorithmsBloc(
          autoSort: BooleanFieldBloc(name: 'Auto Select', initialValue: true),
          bubbleSort: BooleanFieldBloc(name: 'Bubble Sort'),
          heapSort: BooleanFieldBloc(name: 'Heap Sort'),
          insertionSort: BooleanFieldBloc(name: 'Insertion Sort'),
          selectionSort: BooleanFieldBloc(name: 'Selection Sort'),
          mergeSort: BooleanFieldBloc(name: 'Merge Sort'),
          quickSort: BooleanFieldBloc(name: 'Quick Sort'),
        ),
        data = ListFieldBloc<TextFieldBloc, dynamic>(name: 'values') {
    addFieldBlocs(
      fieldBlocs: [
        reverse,
        type,
        iterations,
        algorithms,
        data,
      ],
    );
    for (int i = 0; i < 3; i++) {
      addField();
    }
  }

  final BooleanFieldBloc reverse;
  final SelectFieldBloc type;
  final TextFieldBloc iterations;
  final AlgorithmsBloc algorithms;
  final ListFieldBloc<TextFieldBloc, dynamic> data;

  void addField() => data.addFieldBloc(
        TextFieldBloc(
          validators: [
            FieldBlocValidators.required,
            _dataValidator,
          ],
        )..subscribeToFieldBlocs([type]),
      );

  void removeField(TextFieldBloc fieldBloc) => data.removeFieldBloc(fieldBloc);

  @override
  FutureOr<void> onSubmitting() async {
    List<String> alg = [];
    if (algorithms.autoSort.value) alg.add('auto');
    if (algorithms.bubbleSort.value) alg.add('bubble');
    if (algorithms.heapSort.value) alg.add('heap');
    if (algorithms.insertionSort.value) alg.add('insertion');
    if (algorithms.selectionSort.value) alg.add('selection');
    if (algorithms.mergeSort.value) alg.add('merge');
    if (algorithms.quickSort.value) alg.add('quick');

    final requestData = data.value.map((e) {
      switch (type.value) {
        case DataType.string:
          return e.value;
        case DataType.double:
          return e.valueToDouble;
        case DataType.int:
          return e.valueToInt;
      }
    }).toList();

    emitLoading();
    try {
      final response = await SortApi().simpleSort(SimpleSortRequest(
        algorithms: alg,
        data: requestData,
        iterations: int.tryParse(iterations.value) ?? -1,
        reverse: reverse.value,
      ));
      emitSuccess(successResponse: response);
    } on DioError catch (dioError) {
      emitLoadFailed(
        failureResponse:
            jsonDecode(dioError.response?.toString() ?? '{}')?['message'],
      );
    } catch (e) {
      emitLoadFailed(failureResponse: null);
    }
  }

  String? _dataValidator(String value) {
    switch (type.value) {
      case DataType.double:
        if (double.tryParse(value) == null) return "Wrong data type";
        break;
      case DataType.int:
        if (int.tryParse(value) == null) return "Wrong data type";
        break;
    }
    return null;
  }
}
