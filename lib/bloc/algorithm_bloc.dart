import 'package:flutter_form_bloc/flutter_form_bloc.dart';

class AlgorithmsBloc extends GroupFieldBloc {
  AlgorithmsBloc({
    required this.autoSort,
    required this.bubbleSort,
    required this.heapSort,
    required this.insertionSort,
    required this.selectionSort,
    required this.mergeSort,
    required this.quickSort,
  }) : super(
          name: 'algorithms',
          fieldBlocs: [
            autoSort,
            bubbleSort,
            heapSort,
            insertionSort,
            selectionSort,
            mergeSort,
            quickSort,
          ],
        );

  final BooleanFieldBloc autoSort;
  final BooleanFieldBloc bubbleSort;
  final BooleanFieldBloc heapSort;
  final BooleanFieldBloc insertionSort;
  final BooleanFieldBloc selectionSort;
  final BooleanFieldBloc mergeSort;
  final BooleanFieldBloc quickSort;
}
