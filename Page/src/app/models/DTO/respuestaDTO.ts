
export class RespuestaDTO {

    id: number;
    idUsuario: number;
    idTopico: number;
    idRespuesta: number;
    respuesta: string;
    fecha: Date;

    constructor(id: number, idUsuario: number, idTopico: number, idRespuesta: number, respuesta: string, fecha: Date) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idTopico = idTopico;
        this.idRespuesta = idRespuesta;
        this.respuesta = respuesta;
        this.fecha = fecha;
    }

}
