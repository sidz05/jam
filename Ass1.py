def karatsuba(x, y):
    # Base case for recursion: when the number is single-digit
    if x < 10 or y < 10:
        return x * y
    
    # Number of digits in the largest number
    n = max(len(str(x)), len(str(y)))
    half = n // 2
    
    # Split the numbers into two halves
    a = x // (10 ** half)
    b = x % (10 ** half)

    c = y // (10 ** half)
    d = y % (10 ** half)
    
    # Recursively compute three products
    ac = karatsuba(a, c)
    bd = karatsuba(b, d)
    ad_plus_bc = karatsuba(a + b, c + d) - ac - bd
    
    # Combine the results according to the Karatsuba formula
    return ac * (10 ** (2 * half)) + ad_plus_bc * (10 ** half) + bd

def square(num):
    return karatsuba(num, num)

def multi(num1,num2):
    return karatsuba(num1,num2)

print("ans is:",multi(1234,56789))



# number = int(input("Enter the number to square: "))
# result = square(number)
# print("The square of the number is:", result)
