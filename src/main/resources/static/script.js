//const url = "http://localhost:8080";
const url = "https://thursday-coffee.azurewebsites.net/";

function doAddBookmark(info) {
	let responseData;
	axios
		.post(`${url}/add`, info)
		.then((response) => {
			console.log("Status: ", response.status);
			responseData = response.data;
			console.log("Data: ", response.data);
		})
		.catch((error) => console.log(error));
}

// **** event handlers ****
document.getElementById("submit-new-button").addEventListener("click", () => {
	const info = {
		name: document.getElementById("name-field").value,
		url: document.getElementById("url-field").value,
		description: document.getElementById("description-field").value,
	};
	doAddBookmark(info);
});

document.getElementById("submit-id-button").addEventListener("click", () => {
	const id = document.getElementById("id-number").value;
	let responseData;
	axios.get(`${url}/id/${id}`, id).then((response) => {
		responseData = response.data;
		// putting it into an array to reuse stuff
		displayData([responseData]);
	});
});

document.getElementById("submit-all-button").addEventListener("click", () => {
	let responseData;
	axios.get(`${url}/all`, id).then((response) => {
		responseData = response.data;
		displayData(responseData);
	});
});

// **** end event handlers ****

function displayData(dataArray) {
	let content;
	for (let i=0; i<dataArray.length; i++) {
		content.push(formatIntoHTML(dataArray[i]) + "<br />");
	}
	
	document.getElementById("response").innerHTML = content;
}

function formatIntoHTML(bookmark) {
	const { name, url, description } = bookmark;
	let content = `Name: ${name} <br />Url: <a href="${url}">${url}</a><br />Description: ${description}`;
	return content;
}
