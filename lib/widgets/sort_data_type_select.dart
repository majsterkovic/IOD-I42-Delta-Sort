import 'package:flutter/material.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';

import '../sort_api/sort_api.dart';

class SortDataTypeSelect extends StatelessWidget {
  const SortDataTypeSelect({
    super.key,
    required this.fieldBloc,
  });

  final SelectFieldBloc fieldBloc;

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        Expanded(
          child: RadioButtonGroupFieldBlocBuilder(
            selectFieldBloc: fieldBloc,
            splashRadius: 0,
            padding: const EdgeInsets.all(0),
            decoration: const InputDecoration(
              border: InputBorder.none,
            ),
            itemBuilder: (context, item) => FieldItem(
              child: Text((item as DataType).name),
            ),
          ),
        ),
      ],
    );
  }
}
