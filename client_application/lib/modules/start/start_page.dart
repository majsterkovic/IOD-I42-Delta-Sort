import 'package:flutter/material.dart';
import 'package:sort_client/modules/object_sort/object_sort_page.dart';
import 'package:sort_client/modules/simple_sort/simple_sort_page.dart';

class StartPage extends StatelessWidget {
  const StartPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            const Text(
              "Sorting",
              style: TextStyle(
                color: Colors.orange,
                fontWeight: FontWeight.w600,
                fontSize: 32,
                height: 1,
              ),
            ),
            const SizedBox(height: 8),
            const Text(
              "Madness",
              style: TextStyle(
                color: Colors.red,
                fontWeight: FontWeight.w500,
                fontSize: 28,
                height: 1,
              ),
            ),
            const SizedBox(height: 64),
            DecoratedBox(
              decoration: BoxDecoration(
                border: Border.all(
                  color: Colors.orange,
                ),
                borderRadius: BorderRadius.circular(16),
              ),
              child: TextButton(
                onPressed: () => pushSimpleSort(context),
                style: ButtonStyle(
                  shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                    RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(16.0),
                    ),
                  ),
                ),
                child: const SizedBox(
                  width: 128,
                  height: 32,
                  child: Center(
                    child: Text(
                      "simple sort",
                      style: TextStyle(
                        fontSize: 16,
                      ),
                    ),
                  ),
                ),
              ),
            ),
            const SizedBox(height: 16),
            DecoratedBox(
              decoration: BoxDecoration(
                border: Border.all(
                  color: Colors.orange,
                ),
                borderRadius: BorderRadius.circular(16),
              ),
              child: TextButton(
                onPressed: () => pushObjectSort(context),
                style: ButtonStyle(
                  shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                    RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(16.0),
                    ),
                  ),
                ),
                child: const SizedBox(
                  width: 128,
                  height: 32,
                  child: Center(
                    child: Text(
                      "object sort",
                      style: TextStyle(
                        fontSize: 16,
                      ),
                    ),
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  void pushSimpleSort(BuildContext context) {
    Navigator.of(context).push(
      MaterialPageRoute(
        builder: (context) => const SimpleSortPage(),
      ),
    );
  }

  void pushObjectSort(BuildContext context) {
    Navigator.of(context).push(
      MaterialPageRoute(
        builder: (context) => const ObjectSortPage(),
      ),
    );
  }
}
