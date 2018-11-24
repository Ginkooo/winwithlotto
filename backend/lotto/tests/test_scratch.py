from django.test import TestCase


from lotto import models


class ScratchTests(TestCase):

    def test_can_start_collecting_scratch(self):
        group = models.ScratchGroup.objects.create(name='somegrp')
        atype = models.ScratchType.objects.create(scratch_group=group, name='sometype')
        scratch = models.Scratch.objects.create(latitude=2.31452,
                                                longtitude=4.231412,
                                                scratch_type=atype)
