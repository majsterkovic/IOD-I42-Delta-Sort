import 'package:flutter/material.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';

class SortDirectionSwitch extends StatelessWidget {
  const SortDirectionSwitch({
    super.key,
    required this.fieldBloc,
  });

  final BooleanFieldBloc fieldBloc;

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        const Text(
          'Ascending',
          style: TextStyle(fontSize: 16),
        ),
        SizedBox(
          width: 48,
          height: 32,
          child: SwitchFieldBlocBuilder(
            booleanFieldBloc: fieldBloc,
            body: const SizedBox.shrink(),
            splashRadius: 0,
          ),
        ),
        const Text(
          'Descending',
          style: TextStyle(fontSize: 16),
        ),
      ],
    );
  }
}
