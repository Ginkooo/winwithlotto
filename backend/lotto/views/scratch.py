from rest_framework import viewsets

from lotto import models, serializers


class ScratchTypeViewSet(viewsets.ModelViewSet):
    queryset = models.ScratchType.objects.all()
    serializer_class = serializers.ScratchTypeSerializer


class ScratchGroupViewSet(viewsets.ModelViewSet):
    queryset = models.ScratchGroup.objects.all()
    serializer_class = serializers.ScratchGroupSerializer


class ScratchViewSet(viewsets.ModelViewSet):
    queryset = models.Scratch.objects.all()
    serializer_class = serializers.ScratchSerializer
