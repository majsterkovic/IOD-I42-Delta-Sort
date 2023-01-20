import 'package:json_annotation/json_annotation.dart';

part 'object_sort_request.g.dart';

@JsonSerializable()
class ObjectSortRequest {
  ObjectSortRequest({
    required this.algorithms,
    required this.data,
    required this.key,
    required this.iterations,
    required this.reverse,
  });

  factory ObjectSortRequest.fromJson(Map<String, dynamic> json) =>
      _$ObjectSortRequestFromJson(json);

  final List<String> algorithms;
  final List<dynamic> data;
  final String key;
  final int iterations;
  final bool reverse;

  Map<String, dynamic> toJson() => _$ObjectSortRequestToJson(this);
}
