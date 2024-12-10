###############################################################################
#                                ActorProperties.py
###############################################################################

from vtkmodules.all import *

def main():
    # Configuração inicial do renderizador
    ren = vtkRenderer()
    ren.SetBackground(1, 1, 1)  # Cor de fundo branca

    # Configuração da janela de renderização
    renWin = vtkRenderWindow()
    renWin.AddRenderer(ren)
    renWin.SetWindowName('Actor Properties')
    renWin.SetSize(300, 300)  # Tamanho da janela

    # Configuração do interator para interação
    iren = vtkRenderWindowInteractor()
    iren.SetRenderWindow(renWin)

    # Criação do cone
    coneSource = vtkConeSource()
    coneSource.SetHeight(2.0)
    coneSource.SetRadius(1.0)
    coneSource.SetResolution(50)

    coneMapper = vtkPolyDataMapper()
    coneMapper.SetInputConnection(coneSource.GetOutputPort())

    coneActor = vtkActor()
    coneActor.SetMapper(coneMapper)

    # **Propriedades do Ator**
    # Cor
    coneActor.GetProperty().SetColor(1, 0, 0)  # Vermelho

    # Representação
    # Opções: Wireframe, Points, Surface
    # coneActor.GetProperty().SetRepresentationToWireframe()  # Wireframe
    # coneActor.GetProperty().SetRepresentationToPoints()  # Pontos
    coneActor.GetProperty().SetRepresentationToSurface()  # Superfície (padrão)

    # Transparência
    coneActor.GetProperty().SetOpacity(0)  # Teste com 0, 0.5 e 1

    # Adiciona o ator ao renderizador
    ren.AddActor(coneActor)

    # Renderizar e iniciar interação
    renWin.Render()
    print("Cor: Vermelho | Representação: Wireframe | Opacidade: 0.5")
    iren.Start()


if __name__ == '__main__':
    main()
