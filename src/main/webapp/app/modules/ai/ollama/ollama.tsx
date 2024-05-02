import axios from 'axios';
import React, { useState } from 'react';
import { Row, Col, Button } from 'reactstrap';

export const Ollama = () => {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const fetchData = async () => {
    setLoading(true);
    try {
      const response = await axios.get('api/ai/ollama/tell-me-a-joke');
      console.log(response);
      setData(response.data);
    } catch (error) {
      setError(error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h1>
            <Button color="primary" onClick={fetchData}>
              Tell me a joke
            </Button>
            {loading && <div>Loading...</div>}
            {error && <div>Error: {error.message}</div>}
          </h1>
          {data}
        </Col>
      </Row>
    </div>
  );
};

export default Ollama;
