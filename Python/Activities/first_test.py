import pytest
import math

def test_sqrt():
    num = 25
    assert math.sqrt(num) == 5

@pytest.mark.xfail
def testsquare():
    num = 7
    assert num*num == 40

def testequality():
    assert 10 == 11