import 'package:flutter/material.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';

import '../bloc/object_sort_bloc.dart';

class ObjectSortField extends StatelessWidget {
  const ObjectSortField({
    super.key,
    required this.objectBloc,
    required this.fieldBloc,
  });

  final ObjectBloc objectBloc;
  final KeyValuePairBloc fieldBloc;

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        Expanded(
          child: SizedBox(
            height: 64,
            child: TextFieldBlocBuilder(
              textFieldBloc: fieldBloc.key,
            ),
          ),
        ),
        const SizedBox(width: 16),
        const Text(
          ':',
          style: TextStyle(fontSize: 16),
        ),
        const SizedBox(width: 16),
        Expanded(
          child: SizedBox(
            height: 64,
            child: TextFieldBlocBuilder(
              textFieldBloc: fieldBloc.value,
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
          onPressed: () => objectBloc.removeField(fieldBloc),
        ),
      ],
    );
  }
}
