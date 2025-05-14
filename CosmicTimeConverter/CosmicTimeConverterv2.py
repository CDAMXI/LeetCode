from time import sleep

class CosmicTimeConverter:
    """
    A utility class to convert cosmic time periods (relative to the age of the universe)
    into an equivalent human-life timescale (e.g., years, days, hours, minutes, seconds).
    """

    def __init__(self):
        self.UNIVERSE_AGE_YEARS = 13.8e9  # 13.8 billion years
        self.AVERAGE_HUMAN_LIFESPAN_YEARS = 80  # 80 years

    def convert_to_human_life_scale(self, cosmic_years):
        """
        Converts a cosmic time period (in years) to an equivalent human-life timescale.
        
        Args:
            cosmic_years (float): Time period in cosmic years to convert.
        
        Returns:
            str: Formatted string representing the equivalent in human-life scale 
                 (e.g., "23 years, 66 days, 4 hours, 30 minutes, 15 seconds").
        """
        if cosmic_years < 0:
            raise ValueError("Cosmic years must be non-negative.")

        # Proportional calculation
        equivalent_human_years = (cosmic_years / self.UNIVERSE_AGE_YEARS) * self.AVERAGE_HUMAN_LIFESPAN_YEARS

        # Split into years, days, hours, minutes, and seconds
        years = int(equivalent_human_years)
        remaining_days_fraction = (equivalent_human_years - years) * 365
        days = int(remaining_days_fraction)
        remaining_hours_fraction = (remaining_days_fraction - days) * 24
        hours = int(remaining_hours_fraction)
        remaining_minutes_fraction = (remaining_hours_fraction - hours) * 60
        minutes = int(remaining_minutes_fraction)
        remaining_seconds_fraction = (remaining_minutes_fraction - minutes) * 60
        seconds = int(remaining_seconds_fraction)

        # Build the output string
        time_parts = []
        if years > 0:
            time_parts.append(f"{years} year{'s' if years != 1 else ''}")
        if days > 0:
            time_parts.append(f"{days} day{'s' if days != 1 else ''}")
        if hours > 0:
            time_parts.append(f"{hours} hour{'s' if hours != 1 else ''}")
        if minutes > 0:
            time_parts.append(f"{minutes} minute{'s' if minutes != 1 else ''}")
        if seconds > 0:
            time_parts.append(f"{seconds} second{'s' if seconds != 1 else ''}")

        if not time_parts:  # If all are 0 (e.g., very short times)
            return "less than a second"
        else:
            return ", ".join(time_parts)


# Main program loop
if __name__ == "__main__":
    converter = CosmicTimeConverter()
    print("Cosmic Time to Human Life Scale Converter")
    print("Enter a negative number to exit.")
    
    while True:
        try:
            user_input = input("Enter cosmic time in years: ")
            duration = float(user_input)
            
            if duration < 0:
                print("Exiting program...")
                sleep(1)
                print("Goodbye!")
                break
                
            result = converter.convert_to_human_life_scale(duration)
            print(f"Equivalent human life scale: {result}\n")
            
        except ValueError:
            print("Error: Please enter a valid number.\n")
