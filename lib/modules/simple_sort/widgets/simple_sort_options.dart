import 'package:expandable/expandable.dart';
import 'package:flutter/material.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';
import 'package:sort_client/widgets/sort_algorithm_select.dart';
import 'package:sort_client/widgets/sort_data_type_select.dart';
import 'package:sort_client/widgets/sort_max_iterations_field.dart';

import '../../../widgets/sort_direction_switch.dart';
import '../bloc/simple_sort_bloc.dart';

class SimpleSortOptions extends StatefulWidget {
  const SimpleSortOptions({super.key});

  @override
  State<SimpleSortOptions> createState() => _SimpleSortOptionsState();
}

class _SimpleSortOptionsState extends State<SimpleSortOptions> {
  ExpandableController expandableController = ExpandableController();

  @override
  Widget build(BuildContext context) {
    return ExpandableNotifier(
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 32, vertical: 16),
        child: DecoratedBox(
          decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(16),
            border: Border.all(
              color: Colors.orange,
              width: 2,
            ),
          ),
          child: Expandable(
            controller: expandableController,
            collapsed: _collapsed(),
            expanded: _expanded(),
          ),
        ),
      ),
    );
  }

  Widget _collapsed() => _header(expanded: false);

  Widget _expanded() {
    final formBloc = context.read<SimpleSortBloc>();

    return Column(
      children: [
        _header(expanded: true),
        Padding(
          padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
          child: Column(
            children: [
              SortDirectionSwitch(fieldBloc: formBloc.reverse),
              const SizedBox(height: 16),
              SortDataTypeSelect(fieldBloc: formBloc.type),
              const SizedBox(height: 16),
              SortMaxIterationsField(fieldBloc: formBloc.iterations),
              const SizedBox(height: 16),
              SortAlgorithmSelect(fieldBloc: formBloc.algorithms),
            ],
          ),
        ),
      ],
    );
  }

  Widget _header({required bool expanded}) {
    return TextButton(
      onPressed: () => setState(
        () => expandableController.expanded = !expanded,
      ),
      style: ButtonStyle(
        shape: MaterialStateProperty.all<RoundedRectangleBorder>(
          RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(16.0),
          ),
        ),
      ),
      child: SizedBox(
        height: 48,
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text('Options'),
            const SizedBox(width: 8),
            Icon(expanded ? Icons.expand_less : Icons.expand_more),
          ],
        ),
      ),
    );
  }
}
