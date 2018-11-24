from rest_framework import serializers

from lotto import models


class ScratchTypeSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.ScratchType
        fields = '__all__'
