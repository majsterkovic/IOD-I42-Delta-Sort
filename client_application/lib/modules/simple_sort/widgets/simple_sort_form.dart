import 'package:flutter/material.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';
import 'package:sort_client/modules/simple_sort/bloc/simple_sort_bloc.dart';
import 'package:sort_client/modules/simple_sort/widgets/simple_sort_field.dart';
import 'package:sort_client/modules/simple_sort/widgets/simple_sort_options.dart';

class SimpleSortForm extends StatelessWidget {
  const SimpleSortForm({super.key});

  @override
  Widget build(BuildContext context) {
    final formBloc = context.read<SimpleSortBloc>();
    return SingleChildScrollView(
      child: BlocBuilder<ListFieldBloc<TextFieldBloc, dynamic>,
          ListFieldBlocState<TextFieldBloc, dynamic>>(
        bloc: formBloc.data,
        builder: (context, state) {
          return Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              const SimpleSortOptions(),
              const SizedBox(height: 16),
              ...formBloc.data.value
                  .map(
                    (fieldBloc) => SimpleSortField(
                      formBloc: formBloc,
                      fieldBloc: fieldBloc,
                    ),
                  )
                  .toList(),
              const SizedBox(height: 32),
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
