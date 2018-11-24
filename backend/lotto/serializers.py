from rest_framework import serializers

from lotto import models


class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.User
        fields = '__all__'


class ScratchTypeSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.ScratchType
        fields = '__all__'


class ScratchGroupSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.ScratchGroup
        fields = '__all__'


class AwardSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.Award
        fields = '__all__'


class CoinBagSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.CoinBag
        fields = '__all__'


class ScratchSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.Scratch
        fields = '__all__'
