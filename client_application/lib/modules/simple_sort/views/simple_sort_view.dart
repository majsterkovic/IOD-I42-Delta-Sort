import 'package:flutter/material.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';

import '../../../sort_api/sort_api.dart';
import '../../error/error_page.dart';
import '../../response/response_page.dart';
import '../bloc/simple_sort_bloc.dart';
import '../widgets/simple_sort_form.dart';

class SimpleSortView extends StatelessWidget {
  const SimpleSortView({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Simple Sort"),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: context.read<SimpleSortBloc>().submit,
        child: const Icon(Icons.send),
      ),
      body: BlocConsumer<SimpleSortBloc,
          FormBlocState<List<SortResponse>, String>>(
        listener: (context, state) {
          if (state is FormBlocLoadFailed<List<SortResponse>, String>) {
            _pushErrorPage(context, state);
            context.read<SimpleSortBloc>().emitSubmissionCancelled();
          }
          if (state is FormBlocSuccess<List<SortResponse>, String>) {
            _pushResponsePage(context, state);
            context.read<SimpleSortBloc>().emitSubmissionCancelled();
          }
        },
        builder: (context, state) {
          return const SimpleSortForm();
        },
      ),
    );
  }

  void _pushErrorPage(
    BuildContext context,
    FormBlocLoadFailed<List<SortResponse>, String> state,
  ) {
    Navigator.of(context).push(
      MaterialPageRoute(
        builder: (context) => ErrorPage(
          errorMessage: state.failureResponse,
        ),
      ),
    );
  }

  void _pushResponsePage(
    BuildContext context,
    FormBlocSuccess<List<SortResponse>, String> state,
  ) {
    Navigator.of(context).push(
      MaterialPageRoute(
        builder: (context) => ResponsePage(
          sortedData: state.successResponse ?? [],
        ),
      ),
    );
  }
}
