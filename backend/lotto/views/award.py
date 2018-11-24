from rest_framework import viewsets

from lotto import models, serializers


class AwardViewSet(viewsets.ModelViewSet):
    queryset = models.Award.objects.all()
    serializer_class = serializers.AwardSerializer
