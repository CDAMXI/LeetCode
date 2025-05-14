class CosmicTimeConverter:
    """
    A utility class to convert cosmic time periods (relative to the age of the universe)
    into an equivalent human-life timescale (e.g., years, days).
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
                 (e.g., "23 years, 66 days" or "less than a day").
        """
        # Proportional calculation
        equivalent_human_years = (cosmic_years / self.UNIVERSE_AGE_YEARS) * self.AVERAGE_HUMAN_LIFESPAN_YEARS

        # Split into years and days (rounding to avoid negligible decimals)
        years = int(equivalent_human_years)
        remaining_days = int((equivalent_human_years - years) * 365)

        # Build the output string
        time_parts = []
        if years > 0:
            time_parts.append(f"{years} year{'s' if years != 1 else ''}")
        if remaining_days > 0:
            time_parts.append(f"{remaining_days} day{'s' if remaining_days != 1 else ''}")

        if not time_parts:  # If both are 0 (e.g., very short times)
            return "less than a day"
        else:
            return ", ".join(time_parts)


# Example usage
if __name__ == "__main__":
    converter = CosmicTimeConverter()
    duration = int(input("Enter cosmic time in years: "))
    print(f"Equivalent human life scale: {converter.convert_to_human_life_scale(duration)}")
