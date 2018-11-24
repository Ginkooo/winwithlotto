from rest_framework import viewsets

from lotto import models, serializers


class UserViewSet(viewsets.ModelViewSet):
    queryset = models.User.objects.all()
    serializer_class = serializers.UserSerializer


class CoinBagViewSet(viewsets.ModelViewSet):
    queryset = models.CoinBag.objects.all()
    serializer_class = serializers.CoinBagSerializer
