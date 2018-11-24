import django_filters
from rest_framework import viewsets

from lotto import models, serializers


class ScratchTypeViewSet(viewsets.ModelViewSet):
    queryset = models.ScratchType.objects.all()
    serializer_class = serializers.ScratchTypeSerializer


class ScratchGroupViewSet(viewsets.ModelViewSet):
    queryset = models.ScratchGroup.objects.all()
    serializer_class = serializers.ScratchGroupSerializer


class ScratchViewSet(viewsets.ModelViewSet):
    filterset_fields = {
        'latitude': 'lte gte'.split(),
        'longtitude': 'lte gte'.split(),
    }
    queryset = models.Scratch.objects.all()
    serializer_class = serializers.ScratchSerializer
