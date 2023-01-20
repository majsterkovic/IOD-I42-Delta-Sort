import 'package:flutter/material.dart';

class ErrorPage extends StatelessWidget {
  const ErrorPage({
    super.key,
    this.errorTitle,
    this.errorMessage,
  });

  final String? errorTitle;
  final String? errorMessage;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Error"),
      ),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            const Icon(
              Icons.error_outline_rounded,
              size: 128,
              color: Colors.red,
            ),
            const SizedBox(height: 16),
            if (errorTitle != null) ...[
              Text(
                errorTitle!,
                style: const TextStyle(fontSize: 24),
              ),
              const SizedBox(height: 16),
            ],
            Text(
              errorMessage ?? 'Oops. Something went wrong.',
              style: const TextStyle(fontSize: 16),
            ),
          ],
        ),
      ),
    );
  }
}
