import 'package:flutter/material.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';

import '../bloc/algorithm_bloc.dart';

class SortAlgorithmSelect extends StatelessWidget {
  const SortAlgorithmSelect({
    super.key,
    required this.fieldBloc,
  });

  final AlgorithmsBloc fieldBloc;

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        _buildCheckbox(fieldBloc.autoSort),
        const SizedBox(height: 8),
        _buildCheckbox(fieldBloc.bubbleSort),
        const SizedBox(height: 8),
        _buildCheckbox(fieldBloc.heapSort),
        const SizedBox(height: 8),
        _buildCheckbox(fieldBloc.insertionSort),
        const SizedBox(height: 8),
        _buildCheckbox(fieldBloc.selectionSort),
        const SizedBox(height: 8),
        _buildCheckbox(fieldBloc.mergeSort),
        const SizedBox(height: 8),
        _buildCheckbox(fieldBloc.quickSort),
      ],
    );
  }

  Widget _buildCheckbox(BooleanFieldBloc fieldBloc) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.start,
      children: [
        SizedBox(
          width: 32,
          height: 32,
          child: CheckboxFieldBlocBuilder(
            booleanFieldBloc: fieldBloc,
            splashRadius: 0,
            body: const SizedBox.shrink(),
          ),
        ),
        Text(fieldBloc.name),
      ],
    );
  }
}
