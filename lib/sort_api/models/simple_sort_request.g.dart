// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'simple_sort_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SimpleSortRequest _$SimpleSortRequestFromJson(Map<String, dynamic> json) =>
    SimpleSortRequest(
      algorithms: (json['algorithms'] as List<dynamic>)
          .map((e) => e as String)
          .toList(),
      data: json['data'] as List<dynamic>,
      iterations: json['iterations'] as int,
      reverse: json['reverse'] as bool,
    );

Map<String, dynamic> _$SimpleSortRequestToJson(SimpleSortRequest instance) =>
    <String, dynamic>{
      'algorithms': instance.algorithms,
      'data': instance.data,
      'iterations': instance.iterations,
      'reverse': instance.reverse,
    };
