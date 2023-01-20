// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'object_sort_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ObjectSortRequest _$ObjectSortRequestFromJson(Map<String, dynamic> json) =>
    ObjectSortRequest(
      algorithms: (json['algorithms'] as List<dynamic>)
          .map((e) => e as String)
          .toList(),
      data: json['data'] as List<dynamic>,
      key: json['key'] as String,
      iterations: json['iterations'] as int,
      reverse: json['reverse'] as bool,
    );

Map<String, dynamic> _$ObjectSortRequestToJson(ObjectSortRequest instance) =>
    <String, dynamic>{
      'algorithms': instance.algorithms,
      'data': instance.data,
      'key': instance.key,
      'iterations': instance.iterations,
      'reverse': instance.reverse,
    };
