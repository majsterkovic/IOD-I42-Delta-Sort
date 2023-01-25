import 'dart:async';
import 'dart:convert';

import 'package:dio/dio.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';
import 'package:sort_client/sort_api/sort_api.dart';

import '../../../bloc/algorithm_bloc.dart';

class ObjectSortBloc extends FormBloc<List<SortResponse>, String> {
  ObjectSortBloc()
      : reverse = BooleanFieldBloc(name: 'Reverse'),
        keyName = TextFieldBloc(
          name: "Key Name",
          validators: [FieldBlocValidators.required],
        ),
        type = SelectFieldBloc(
          name: 'Key Type',
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
        data = ListFieldBloc<ObjectBloc, dynamic>(name: 'values') {
    addFieldBlocs(
      fieldBlocs: [
        reverse,
        keyName,
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
  final TextFieldBloc keyName;
  final SelectFieldBloc type;
  final TextFieldBloc iterations;
  final AlgorithmsBloc algorithms;
  final ListFieldBloc<ObjectBloc, dynamic> data;

  void addField() => data.addFieldBloc(
        ObjectBloc(
          key: TextFieldBloc(validators: [_keyValidator])
            ..subscribeToFieldBlocs([type]),
          data: ListFieldBloc<KeyValuePairBloc, dynamic>(),
          keyValidator: _objectKeyValidator,
        ),
      );

  void removeField(ObjectBloc fieldBloc) => data.removeFieldBloc(fieldBloc);

  Future<void> submit2() async {
    if (!await reverse.validate()) return;
    if (!await keyName.validate()) return;
    if (!await type.validate()) return;
    if (!await iterations.validate()) return;
    if (!await algorithms.validate()) return;
    if (!await data.validate()) return;
    await onSubmitting();
  }

  @override
  FutureOr<void> onSubmitting() async {
    print('doopa');

    List<String> alg = [];
    if (algorithms.autoSort.value) alg.add('auto');
    if (algorithms.bubbleSort.value) alg.add('bubble');
    if (algorithms.heapSort.value) alg.add('heap');
    if (algorithms.insertionSort.value) alg.add('insertion');
    if (algorithms.selectionSort.value) alg.add('selection');
    if (algorithms.mergeSort.value) alg.add('merge');
    if (algorithms.quickSort.value) alg.add('quick');

    final requestData = data.value.map((e) {
      final map = <String, dynamic>{};
      switch (type.value) {
        case DataType.string:
          map[keyName.value] = e.key.value;
          break;
        case DataType.double:
          map[keyName.value] = e.key.valueToDouble;
          break;
        case DataType.int:
          map[keyName.value] = e.key.valueToInt;
          break;
      }
      for (var pair in e.data.value) {
        map[pair.key.value] = pair.value.value;
      }
      return map;
    }).toList();

    final request = ObjectSortRequest(
      algorithms: alg,
      data: requestData,
      key: keyName.value,
      iterations: int.tryParse(iterations.value) ?? -1,
      reverse: reverse.value,
    );

    emitLoading();
    try {
      final response = await SortApi().objectSort(ObjectSortRequest(
        algorithms: alg,
        data: requestData,
        key: keyName.value,
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

  String? _keyValidator(String value) {
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

  String? _objectKeyValidator(String value) {
    if (value == keyName.value) {
      return 'field and key can\'t have the same name';
    }
    return null;
  }
}

class ObjectBloc extends GroupFieldBloc {
  ObjectBloc({
    required this.key,
    required this.data,
    required this.keyValidator,
  }) : super(fieldBlocs: [
          key,
          data,
        ]);

  final String? Function(String) keyValidator;
  final TextFieldBloc key;
  final ListFieldBloc<KeyValuePairBloc, dynamic> data;

  void addField() => data.addFieldBloc(
        KeyValuePairBloc(
          key: TextFieldBloc(
            validators: [
              FieldBlocValidators.required,
              keyValidator,
            ],
          ),
          value: TextFieldBloc(
            validators: [
              FieldBlocValidators.required,
            ],
          ),
        ),
      );

  void removeField(KeyValuePairBloc fieldBloc) =>
      data.removeFieldBloc(fieldBloc);
}

class KeyValuePairBloc extends GroupFieldBloc {
  KeyValuePairBloc({
    required this.key,
    required this.value,
  }) : super(
          fieldBlocs: [
            key,
            value,
          ],
        );

  final TextFieldBloc key;
  final TextFieldBloc value;
}
