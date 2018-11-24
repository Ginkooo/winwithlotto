from rest_framework import viewsets

from lotto import models, serializers


class ScratchTypeViewSet(viewsets.ModelViewSet):
    queryset = models.ScratchType.objects.all()
    serializer_class = serializers.ScratchTypeSerializer


class ScratchGroupViewSet(viewsets.ModelViewSet):
    queryset = models.ScratchGroup.objects.all()
    serializer_class = serializers.ScratchGroupSerializer


class AwardViewSet(viewsets.ModelViewSet):
    queryset = models.Award.objects.all()
    serializer_class = serializers.AwardSerializer


class UserViewSet(viewsets.ModelViewSet):
    queryset = models.User.objects.all()
    serializer_class = serializers.UserSerializer


class UserViewSet(viewsets.ModelViewSet):
    queryset = models.User.objects.all()
    serializer_class = serializers.UserSerializer


class UserViewSet(viewsets.ModelViewSet):
    queryset = models.User.objects.all()
    serializer_class = serializers.UserSerializer
