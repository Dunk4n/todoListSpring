function changeTodoCompleted(e, id)
{
	fetch('http://localhost:9001/todo/' + id + '/toggleCompleted')
		.then(response => {
			if (!response.ok)
				throw new Error('Something went wrong');
			return response.json();
		})
		.then(data => {
			var todoTitleElm = document.getElementById("todo_title_" + id)
			if (todoTitleElm == null)
				return;
			if (data) {
				todoTitleElm.style = "text-decoration: line-through";
				e.target.checked = true;
			}
			else {
				todoTitleElm.style = "";
				e.target.checked = false;
			}
		}).catch(err => {
			console.error('Error', err);
			e.target.checked = !e.target.checked;
		});
}
