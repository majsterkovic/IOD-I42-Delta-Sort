import 'package:flutter/material.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';

class ObjectSortKey extends StatelessWidget {
  const ObjectSortKey({
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
          'Key name',
          style: TextStyle(fontSize: 16),
        ),
        const SizedBox(width: 8),
        Expanded(
          child: TextFieldBlocBuilder(
            textFieldBloc: fieldBloc,
            decoration: const InputDecoration(),
          ),
        ),
      ],
    );
  }
}
