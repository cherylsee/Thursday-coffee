//const url = "http://localhost:8080";
const url = "https://thursday-coffee.azurewebsites.net/";

function doAddBookmark(info) {
	let responseData;
	axios
		.post(`${url}/add`, info)
		.then((response) => {
			console.log("Status: ", response.status);
			responseData = response.data;
			console.log("Response data: ", response.data);
			document.getElementById(
				"response"
			).innerHTML = `Successfully added ${info.name} as bookmark #${responseData.id}`;
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
	console.log("clicked");
	let responseData;
	axios.get(`${url}/all`, {}).then((response) => {
		responseData = response.data;
		displayData(responseData);
	});
	console.log("Results: ", responseData);
});

// Quack?!
let nodes = document.getElementsByClassName("rubber-ducky");
for (let i = 0; i < nodes.length; i++) {
	nodes[i].addEventListener("click", () => {
		document.getElementById("audio_quack").play();
	});
}

// **** end event handlers ****

function displayData(dataArray) {
	let content = "";
	for (let i = 0; i < dataArray.length; i++) {
		content += formatIntoHTML(dataArray[i]) + "<br />";
	}

	document.getElementById("response").innerHTML = content;
}

function formatIntoHTML(bookmark) {
	const { id, name, url, description } = bookmark;
	let content = `<b>Name:</b> ${name} &nbsp;&nbsp;&nbsp;&nbsp; <b>ID:</b> ${id} <br /><b>Url:</b> <a href="${url}" target="_new">${url}</a><br /><b>Description:</b> ${description}`;
	return content;
}
