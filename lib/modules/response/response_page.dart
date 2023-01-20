import 'package:flutter/material.dart';
import 'package:sort_client/modules/response/widgets/response_card.dart';
import 'package:sort_client/sort_api/models/models.dart';

class ResponsePage extends StatelessWidget {
  const ResponsePage({
    super.key,
    required this.sortedData,
  });

  final List<SortResponse> sortedData;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Sorting Results"),
      ),
      body: SingleChildScrollView(
        child: Column(
          children: sortedData
              .map((response) => ResponseCard(response: response))
              .toList(),
        ),
      ),
    );
  }
}
