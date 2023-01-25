import 'package:flutter/material.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';
import 'package:sort_client/modules/object_sort/views/object_sort_view.dart';

import 'bloc/object_sort_bloc.dart';

class ObjectSortPage extends StatelessWidget {
  const ObjectSortPage({super.key});

  @override
  Widget build(BuildContext context) {
    return BlocProvider(
      create: (context) => ObjectSortBloc(),
      lazy: false,
      child: const ObjectSortView(),
    );
  }
}
