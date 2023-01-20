import 'package:flutter/material.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';

import '../bloc/object_sort_bloc.dart';
import 'object_sort_object.dart';
import 'object_sort_options.dart';

class ObjectSortForm extends StatelessWidget {
  const ObjectSortForm({super.key});

  @override
  Widget build(BuildContext context) {
    final formBloc = context.read<ObjectSortBloc>();
    return SingleChildScrollView(
      child: BlocBuilder<ListFieldBloc<ObjectBloc, dynamic>,
          ListFieldBlocState<ObjectBloc, dynamic>>(
        bloc: formBloc.data,
        builder: (context, state) {
          return Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              const ObjectSortOptions(),
              const SizedBox(height: 8),
              ...formBloc.data.value
                  .map(
                    (fieldBloc) => ObjectSortObject(
                      formBloc: formBloc,
                      fieldBloc: fieldBloc,
                    ),
                  )
                  .toList(),
              const SizedBox(height: 8),
              IconButton(
                splashRadius: 32,
                iconSize: 48,
                onPressed: () => formBloc.addField(),
                icon: const Icon(
                  Icons.add_rounded,
                  color: Colors.orange,
                ),
              ),
            ],
          );
        },
      ),
    );
  }
}
