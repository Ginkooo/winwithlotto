from rest_framework import viewsets

from lotto import models, serializers


class ScratchTypeViewSet(viewsets.ModelViewSet):
    queryset = models.ScratchType.objects.all()
    serializer_class = serializers.ScratchTypeSerializer
