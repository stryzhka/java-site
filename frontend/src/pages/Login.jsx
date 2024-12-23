import Container from 'react-bootstrap/esm/Container'
import Form from 'react-bootstrap/Form'
import { Button } from 'react-bootstrap'

export default function Login () {
    return (
        <Container className="h-100 align-content-center justify-content-center">
            <Container className="w-25 p-4 rounded-3 align-content-center bg-body-secondary">
                <Form className="mb-5">
                    <Form.Group className="mb-3">
                        <Form.Label>Логин</Form.Label>
                        <Form.Control type="text" placeholder="dolbaeb"/>
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Пароль</Form.Label>
                        <Form.Control type="password"/>
                    </Form.Group>
                    <Button variant="primary" type="submit">
                        Войти
                    </Button>
                </Form>
                <Container className="text-center">
                    <Button variant="link" href="#">
                        Регистрация
                    </Button>
                </Container>
            </Container>
        </Container>
    )
}