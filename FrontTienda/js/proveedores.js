//Funcion para traer los datos de proveedores
function loadData(){
    let request = sendRequest('list/proveedores', 'GET', '');
    let table = document.getElementById('proveedor-table');
    table.innerHTML = "";
    request.onload = function(){
        let data = request.response;
        console.log(data);
        data.forEach((element, index) => {
            table.innerHTML += `
            <tr>
                <th>${element.id}</th>
                <td>${element.nit}</th>
                <td>${element.nombre}</th>
                <td>${element.ciudad}</th>
                <td>${element.telefono}</th>
                <td>${element.direccion}</th>
                <td> 
                    <button type="button" class="btn-primary" onclick='window.location = 
                    "form_proveedores.html?idproveedor=${element.id}"'>Ver</button>
                </td>
            </tr>`

        });
    }
    request.onerror = function() {
        table.innerHTML = `
        <tr>
            <td colspan="5">Error al recuperar los datos.</td>
        </tr>`;
    };
}

//funcion para actualizar los datos de un proveedor
function loadProveedor(idproveedor){
    let request = sendRequest('list/proveedores/'+idproveedor, 'GET', '')
    let ciudad = document.getElementById('proveedor-ciudad')
    let id = document.getElementById('proveedor-id')
    let nit = document.getElementById('proveedor-nit')
    let nombre = document.getElementById('proveedor-nombre')
    let telefono = document.getElementById('proveedor-telefono')
    let direccion = document.getElementById('proveedor-direccion')
    request.onload = function(){
        let data = request.response;
        //Se actualiza el valor de las variables segun el JSON
        console.log(data);
        id.value = data.id
        ciudad.value = data.ciudad
        nit.value = data.nit
        nombre.value = data.nombre
        telefono.value = data.telefono
        direccion.value = data.direccion
    }
    request.onerror = function(){
        alert("Error al recuperar los datos.")
    }
}


// Función para guardar un proveedor
function saveProveedor(){
    let ciudad = document.getElementById('proveedor-ciudad').value;
    let id = document.getElementById('proveedor-id').value;
    let nit = document.getElementById('proveedor-nit').value;
    let nombre = document.getElementById('proveedor-nombre').value;
    let telefono = document.getElementById('proveedor-telefono').value;
    let direccion = document.getElementById('proveedor-direccion').value;

    // Crear el objeto con los datos del proveedor
    let data = {
        "id": id, 
        "ciudad": ciudad, 
        "direccion": direccion, 
        "nombre": nombre, 
        "telefono": telefono, 
        "nit": nit
    };

    // Verificar si el ID existe, si es así se editará, de lo contrario se agregará
    let url = id ? `proveedor/editar/${id}` : 'proveedor/agregar';
    let method = id ? 'PUT' : 'POST';

    // Llamar a la función sendRequest con la URL y método correctos
    let request = sendRequest(url, method, data);
    
    request.onload = function() {
        alert('Proveedor creado o actualizado con éxito.');
        window.location = 'proveedores.html';
    }

    request.onerror = function() {
        alert('Error al guardar los cambios.');
    }
}


function deleteProveedor(){
    let id = document.getElementById('proveedor-id').value
    let request = sendRequest('proveedor/' +id , 'DELETE', '')
    request.onload= function() {
        alert('Registro eliminado exitosamente')
        window.location = 'proveedores.html';
    }
    request.onerror = function() {
        alert('Error al elminar el registro.')
    }
}
