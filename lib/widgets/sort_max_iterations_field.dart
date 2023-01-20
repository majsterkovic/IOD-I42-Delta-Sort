import 'package:flutter/material.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';

class SortMaxIterationsField extends StatelessWidget {
  const SortMaxIterationsField({
    super.key,
    required this.fieldBloc,
  });

  final TextFieldBloc fieldBloc;

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        const Text(
          'Max iterations',
          style: TextStyle(fontSize: 16),
        ),
        const SizedBox(width: 8),
        SizedBox(
          width: 48,
          height: 32,
          child: TextFieldBlocBuilder(
            textFieldBloc: fieldBloc,
            decoration: const InputDecoration(),
          ),
        ),
      ],
    );
  }
}
