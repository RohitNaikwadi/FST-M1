import pytest

@pytest.mark.great
def test_greater():
    x = 2
    y = 5
    assert y > x

@pytest.mark.great
def test_greater_equal():
    x = 6
    y = 6
    assert y >= x

@pytest.mark.others
def test_lesser():
    x = 2
    y = 5
    assert x < y