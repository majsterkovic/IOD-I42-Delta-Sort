import 'package:flutter/material.dart';
import 'package:flutter_form_bloc/flutter_form_bloc.dart';

import '../../../sort_api/sort_api.dart';
import '../../error/error_page.dart';
import '../../response/response_page.dart';
import '../bloc/object_sort_bloc.dart';
import '../widgets/object_sort_form.dart';

class ObjectSortView extends StatelessWidget {
  const ObjectSortView({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Object Sort"),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: context.read<ObjectSortBloc>().submit2,
        child: const Icon(Icons.send),
      ),
      body: BlocConsumer<ObjectSortBloc,
          FormBlocState<List<SortResponse>, String>>(
        listener: (context, state) {
          if (state is FormBlocLoadFailed<List<SortResponse>, String>) {
            _pushErrorPage(context, state);
            context.read<ObjectSortBloc>().emitSubmissionCancelled();
          }
          if (state is FormBlocSuccess<List<SortResponse>, String>) {
            _pushResponsePage(context, state);
            context.read<ObjectSortBloc>().emitSubmissionCancelled();
          }
        },
        builder: (context, state) {
          return const ObjectSortForm();
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
