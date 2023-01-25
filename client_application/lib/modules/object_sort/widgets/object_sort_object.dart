import 'package:flutter/material.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';

import '../bloc/object_sort_bloc.dart';
import 'object_sort_field.dart';

class ObjectSortObject extends StatelessWidget {
  const ObjectSortObject({
    super.key,
    required this.formBloc,
    required this.fieldBloc,
  });

  final ObjectSortBloc formBloc;
  final ObjectBloc fieldBloc;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 48, vertical: 8),
      child: BlocBuilder<ListFieldBloc<KeyValuePairBloc, dynamic>,
          ListFieldBlocState<KeyValuePairBloc, dynamic>>(
        bloc: fieldBloc.data,
        builder: (context, state) {
          return DecoratedBox(
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(16),
              border: Border.all(
                color: Colors.grey.shade600,
                width: 1,
              ),
            ),
            child: Padding(
              padding: const EdgeInsets.all(16),
              child: Column(
                children: [
                  Row(
                    children: [
                      const Text(
                        'Key:',
                        style: TextStyle(fontSize: 16),
                      ),
                      const SizedBox(width: 16),
                      Expanded(
                        child: SizedBox(
                          height: 64,
                          child: TextFieldBlocBuilder(
                            textFieldBloc: fieldBloc.key,
                          ),
                        ),
                      ),
                    ],
                  ),
                  ...fieldBloc.data.value
                      .map(
                        (e) => ObjectSortField(
                          objectBloc: fieldBloc,
                          fieldBloc: e,
                        ),
                      )
                      .toList(),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      TextButton(
                        onPressed: () => fieldBloc.addField(),
                        child: const Text('add field'),
                      ),
                      const SizedBox(width: 16),
                      TextButton(
                        onPressed: () => formBloc.removeField(fieldBloc),
                        child: const Text(
                          'remove object',
                          style: TextStyle(
                            color: Colors.red,
                          ),
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ),
          );
        },
      ),
    );
  }
}
