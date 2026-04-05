from random import randint

def play_guess_number():
    print("🎯 Welcome to the Guess the Number Game!")
    print("I've chosen a secret number between 1 and 10. Try to guess it!\n")

    secret = randint(1, 10)
    attempts = 0

    while True:
        try:
            guess = int(input("👉 Enter your guess: "))
        except ValueError:
            print("⚠️ Please enter a valid number.\n")
            continue

        attempts += 1

        if guess == secret:
            print(f"🎉 Correct! The secret number was {secret}.")
            print(f"It took you {attempts} attempt(s). 👏")
            break
        elif guess < secret:
            print("🔼 The secret number is HIGHER.\n")
        else:
            print("🔽 The secret number is LOWER.\n")

if __name__ == "__main__":
    play_guess_number()
