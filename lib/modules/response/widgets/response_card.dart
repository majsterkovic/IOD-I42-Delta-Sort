import 'package:flutter/material.dart';
import 'package:sort_client/sort_api/models/models.dart';

class ResponseCard extends StatelessWidget {
  const ResponseCard({
    super.key,
    required this.response,
  });

  final SortResponse response;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 32, vertical: 16),
      child: DecoratedBox(
        decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(16),
          border: Border.all(
            color: Colors.orange,
            width: 2,
          ),
        ),
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    "Algorithm: ${response.algorithm}",
                    style: const TextStyle(
                      fontWeight: FontWeight.w600,
                      fontSize: 16,
                    ),
                  ),
                  Text(
                    "Time: ${response.time}",
                    style: const TextStyle(
                      fontWeight: FontWeight.w600,
                      fontSize: 16,
                    ),
                  ),
                ],
              ),
              const SizedBox(height: 8),
              const Text(
                'Data:',
                style: TextStyle(
                  fontWeight: FontWeight.w600,
                  fontSize: 16,
                ),
              ),
              ...response.data.map((e) => dataField(e)).toList(),
            ],
          ),
        ),
      ),
    );
  }

  Widget dataField(dynamic data) {
    if (data is Map<String, dynamic>) {
      return Padding(
        padding: const EdgeInsets.symmetric(vertical: 4),
        child: Row(
          children: [
            Expanded(
              child: DecoratedBox(
                decoration: BoxDecoration(
                  border: Border.all(
                    color: Colors.grey.shade600,
                  ),
                  borderRadius: BorderRadius.circular(8),
                ),
                child: Padding(
                  padding: const EdgeInsets.all(8),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: data.entries
                        .map(
                          (e) => Row(
                            children: [
                              Text(
                                e.key,
                                style: const TextStyle(
                                  fontWeight: FontWeight.w500,
                                ),
                              ),
                              Text(': ${e.value}'),
                            ],
                          ),
                        )
                        .toList(),
                  ),
                ),
              ),
            ),
          ],
        ),
      );
    } else {
      return Padding(
        padding: const EdgeInsets.symmetric(horizontal: 16),
        child: Text(
          data.toString(),
          style: const TextStyle(fontSize: 15),
        ),
      );
    }
  }
}
