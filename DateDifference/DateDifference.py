from datetime import date


def ask_date(order):
    while True:
        try:
            user_input = input(f"Enter the {order} date (DD MM YYYY): ").strip().split()
            if len(user_input) != 3:
                raise ValueError("Please enter exactly three numbers: DD MM YYYY.")
            day, month, year = map(int, user_input)
            return date(year, month, day)
        except ValueError as e:
            print(f"Error: {e} Please try again.")


def main():
    while True:
        date1 = ask_date("first")
        date2 = ask_date("second")

        if date1 > date2:
            date1, date2 = date2, date1  # Swap dates if the first is after the second

        delta = date2 - date1
        years = (date2.year - date1.year) - ((date2.month, date2.day) < (date1.month, date1.day))
        months = ((date2.year - date1.year) * 12 + date2.month - date1.month) - (date2.day < date1.day)
        remaining_days = (date2 - date(date2.year, date2.month, date1.day if date2.day >= date1.day else 1)).days

        result_parts = []
        if years:
            result_parts.append(f"{years} year{'s' if years != 1 else ''}")
        if months % 12:
            result_parts.append(f"{months % 12} month{'s' if months % 12 != 1 else ''}")
        if remaining_days:
            result_parts.append(f"{remaining_days} day{'s' if remaining_days != 1 else ''}")

        result = "Elapsed time: " + ", ".join(result_parts) if result_parts else "No difference. Both dates are the same."
        print(result)
        print("_" * 56)


if __name__ == "__main__":
    main()
