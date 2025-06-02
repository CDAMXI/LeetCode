def compare(s1, s2):
    # Check for equality ignoring case
    if s1.lower() == s2.lower():
        return "Both names are the same"

    # Convert both strings to lowercase
    lower_s1 = s1.lower()
    lower_s2 = s2.lower()

    # Find first differing index
    min_length = min(len(lower_s1), len(lower_s2))
    for i in range(min_length):
        if lower_s1[i] != lower_s2[i]:
            return f"Names are different [{lower_s1[i:]}],[{lower_s2[i:]}]"

    # One string is a prefix of the other
    return f"Names are different [{lower_s1[min_length:]}],[{lower_s2[min_length:]}]"


def main():
    first_name = input("Enter the first name: ")
    second_name = input("Enter the second name: ")
    print(compare(first_name, second_name))


if __name__ == "__main__":
    main()
