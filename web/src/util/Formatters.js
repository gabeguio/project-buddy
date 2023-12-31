// Truncate the description if it exceeds the maximum length
const truncateText = (desc, maxDescriptionLength = 150) => {
  //Set the max description length

  //If the current desc is large than maxDesc, then return truncated description
  if (desc.length > maxDescriptionLength) {
    desc = desc.slice(0, maxDescriptionLength) + "...";
  }
  return desc;
};

//Format a date from the date model
const truncateDate = (date) => {
  return date.substring(0, 10).replaceAll("-", ".");
};

const formatDateAndTime = (date) => {
    return date.substring(0, 19).replaceAll("-", ".").replaceAll("T", " @ ");
  };

//Format owner text
function abbreviateLastName(string) {
  let words = string.split(' ');
  words[1] = words[1][0] + '.';
  return words.join(' ');
}


export { truncateText, truncateDate, formatDateAndTime, abbreviateLastName };
