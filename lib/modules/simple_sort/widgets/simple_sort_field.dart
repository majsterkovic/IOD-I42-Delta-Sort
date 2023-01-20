import 'package:flutter/material.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';
import 'package:sort_client/modules/simple_sort/bloc/simple_sort_bloc.dart';

class SimpleSortField extends StatelessWidget {
  const SimpleSortField({
    super.key,
    required this.formBloc,
    required this.fieldBloc,
  });

  final SimpleSortBloc formBloc;
  final TextFieldBloc fieldBloc;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 64),
      child: Row(
        children: [
          Expanded(
            child: SizedBox(
              height: 64,
              child: TextFieldBlocBuilder(
                textFieldBloc: fieldBloc,
              ),
            ),
          ),
          const SizedBox(width: 16),
          IconButton(
            splashRadius: 24,
            icon: const Icon(
              Icons.delete,
              color: Colors.red,
            ),
            onPressed: () => formBloc.removeField(fieldBloc),
          ),
        ],
      ),
    );
  }
}
