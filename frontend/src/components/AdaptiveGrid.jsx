import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import NewsCard from './NewsCard';

export default function AdaptiveGrid () {
    return (
        <Container>
            <Container className="w-50 pt-5">
                <Row className="gy-3" lg={1}>
                    <Col><NewsCard/></Col>
                    <Col><NewsCard/></Col>
                    <Col><NewsCard/></Col>
                    <Col><NewsCard/></Col>
                    <Col><NewsCard/></Col>
                    <Col><NewsCard/></Col>
                    <Col><NewsCard/></Col>
                    <Col><NewsCard/></Col>
                    <Col><NewsCard/></Col>
                    <Col><NewsCard/></Col>
                </Row>
            </Container>
        </Container>
    );
}