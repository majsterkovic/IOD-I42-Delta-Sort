import 'package:json_annotation/json_annotation.dart';

part 'simple_sort_request.g.dart';

@JsonSerializable()
class SimpleSortRequest {
  SimpleSortRequest({
    required this.algorithms,
    required this.data,
    required this.iterations,
    required this.reverse,
  });

  factory SimpleSortRequest.fromJson(Map<String, dynamic> json) =>
      _$SimpleSortRequestFromJson(json);

  final List<String> algorithms;
  final List<dynamic> data;
  final int iterations;
  final bool reverse;

  Map<String, dynamic> toJson() => _$SimpleSortRequestToJson(this);
}
