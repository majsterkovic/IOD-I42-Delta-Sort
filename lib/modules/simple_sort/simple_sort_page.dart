import 'package:flutter/material.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';

import 'bloc/simple_sort_bloc.dart';
import 'views/simple_sort_view.dart';

class SimpleSortPage extends StatelessWidget {
  const SimpleSortPage({super.key});

  @override
  Widget build(BuildContext context) {
    return BlocProvider(
      create: (context) => SimpleSortBloc(),
      lazy: false,
      child: const SimpleSortView(),
    );
  }
}
