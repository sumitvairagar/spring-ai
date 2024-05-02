import './home.scss';

import React from 'react';
import { Link } from 'react-router-dom';
import { Translate } from 'react-jhipster';
import { Row, Col, Alert } from 'reactstrap';

import { useAppSelector } from 'app/config/store';

export const Home = () => {
  const account = useAppSelector(state => state.authentication.account);

  return (
    <Row>
      <Col md="3" className="pad"></Col>
      <Col md="9">
        <h1 className="display-4">Welcome, to Spring AI!</h1>
        <p className="lead">
          <Translate contentKey="home.subtitle">This is your homepage</Translate>
        </p>
        <p>
          List of models integrated
          <ul>
            <Link to="/ai/ollama" className="alert-link">
              Ollama
            </Link>
          </ul>
        </p>
      </Col>
    </Row>
  );
};

export default Home;
