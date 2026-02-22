/**
 * Formats a date string to MM/DD/YYYY format
 * @param dateString - ISO date string or any valid date string
 * @returns Formatted date string in MM/DD/YYYY format
 */
export const formatDate = (dateString: string): string => {
  const date = new Date(dateString)
  return date.toLocaleDateString('en-US', { 
    month: '2-digit', 
    day: '2-digit', 
    year: 'numeric' 
  })
}
